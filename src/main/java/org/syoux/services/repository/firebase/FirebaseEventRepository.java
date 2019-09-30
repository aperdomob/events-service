package org.syoux.services.repository.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.syoux.services.dao.EventDao;
import org.syoux.services.entity.EventEntity;
import org.syoux.services.mapper.EventMapper;
import org.syoux.services.repository.EventRepository;

@Component
public class FirebaseEventRepository implements ValueEventListener, EventRepository {
  private final String PATH = "events";

  private DatabaseReference reference;
  private Map<String, EventEntity> table;

  @Autowired
  private EventMapper eventMapper;

  public FirebaseEventRepository() {
    this(FirebaseDatabase.getInstance());
  }

  public FirebaseEventRepository(FirebaseDatabase database) {
    this.reference = database.getReference();
    this.reference.child(PATH).addValueEventListener(this);
  }

  @Override
  public List<EventEntity> getAllEvents() {
    return null;
  }

  @Override
  public EventEntity save(EventEntity event) {
    DatabaseReference newItemReference = this.reference.child(PATH).push();
    String eventId = newItemReference.getKey();

    EventDao dao = this.eventMapper.entityToDao(event);
    newItemReference.setValueAsync(dao);

    event.setId(eventId);

    return event;
  }

  @Override
  public void onDataChange(DataSnapshot snapshot) {
    for (DataSnapshot children: snapshot.getChildren()) {
      EventDao dao = children.getValue(EventDao.class);
//      EventEntity entity = EventMapper.INSTANCE.daoToModel(dao);
      //    entity.setId(children.getKey());

      // this.table.put(entity.getId(), entity);
    }
  }

  @Override
  public void onCancelled(DatabaseError error) {

  }
}
