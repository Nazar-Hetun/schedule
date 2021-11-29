package elinext.schedule.service.impl;

import elinext.schedule.exception.DataProcessingException;
import elinext.schedule.model.Group;
import elinext.schedule.repository.GroupRepository;
import elinext.schedule.service.GroupService;
import java.time.DayOfWeek;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group add(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group get(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new DataProcessingException("Can't find group by id " + id));
    }

    @Override
    public Group findByIdAndDayOfWeek(Long id, DayOfWeek dayOfWeek) {
        return groupRepository.findByIdAndDayOfWeek(id, dayOfWeek)
                .orElseThrow(() -> new DataProcessingException( "Can't find group by id " + id));
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.getAll();
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

}
