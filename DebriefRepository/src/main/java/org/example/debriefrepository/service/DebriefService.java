package org.example.debriefrepository.service;

import lombok.RequiredArgsConstructor;
import org.example.debriefrepository.entity.Debrief;
import org.example.debriefrepository.entity.User;
import org.example.debriefrepository.repository.DebriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DebriefService {

    @Autowired
    private final DebriefRepository debriefRepository;

    public Debrief createDebrief(Debrief debrief) {
        debriefRepository.save(debrief);
        return debrief;
    }

    public List<Debrief> getAllDebriefs() {
        return debriefRepository.findAll();
    }

    public Debrief getDebriefById(Long id) {
        return debriefRepository.findById(id).orElse(null);
    }

    public List<Debrief> getAllDebriefsByUser(User user) {
        return (List<Debrief>) debriefRepository.findAll().stream()
                .filter(debrief -> debrief.getUser().equals(user))
                .findAny()
                .orElse(null);
    }

    public Boolean deleteDebriefById(Long id) {
        if(getDebriefById(id) == null) {
            return false;
        }
        debriefRepository.deleteById(id);
        return true;
    }

    public Debrief updateDebriefById(Long id, Debrief debrief) {
        Debrief existingDebrief = getDebriefById(id);
        if (existingDebrief != null) {
            existingDebrief.setContent(debrief.getContent());
            existingDebrief.setDate(debrief.getDate());
            existingDebrief.setLessons(debrief.getLessons());
            existingDebrief.setMissions(debrief.getMissions());
            debriefRepository.save(existingDebrief);
        }
        return existingDebrief;
    }
}
