package company.dotin.service;

import company.dotin.model.CategoryElement;
import company.dotin.model.Employe;
import company.dotin.model.Leave;
import company.dotin.repository.CategoryElementRepository;
import company.dotin.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository repository;
    @Autowired
    private CategoryElementRepository elementRepository;

    public void save(Leave leave) {

        repository.save(leave);

    }

    public Leave findbyId(int id) {
        return repository.findById(id);
    }

    public int checkOverLap(List<Leave> leaves, LocalDate fromDate) {
        int overLap = 0;
        for (Leave leave : leaves) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 30; j++)
                    if (fromDate.plusDays(i).equals(leave.getC_fromDate().plusDays(j)) || fromDate.equals(leave.getC_fromDate())) {
                        overLap++;
                        break;
                    } else if (leave.getC_toDate().equals(leave.getC_fromDate().plusDays(j))) break;


            }
        }
        return overLap;
    }

    public List<Leave> findManagerRequestLeaves(int managerId) {
        return repository.findManagerRequestLeaves(managerId);
    }

    public List<Leave> findListByEmploye(Employe employe) {

        return repository.findListByEmploye(employe);
    }

    public void update(Leave leave) {
        repository.update(leave);
    }

    public Leave findByEmploye(Employe employe) {
        return repository.findByEmploye(employe);
    }

    public CategoryElement findStatusByName(String name) {
        return elementRepository.findeByname(name);
    }
}
