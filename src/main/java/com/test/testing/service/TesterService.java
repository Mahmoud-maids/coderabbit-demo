package com.test.testing.service;

import com.test.testing.dto.TesterDTO;
import com.test.testing.dto.TesterLogDTO;
import com.test.testing.entity.Tester;
import com.test.testing.entity.TesterLog;
import com.test.testing.repository.TesterLogRepository;
import com.test.testing.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterService {

    private final TesterRepository testerRepository;

    private final TesterLogRepository testerLogRepository;

    @Autowired
    public TesterService(TesterRepository testerRepository, TesterLogRepository testerLogRepository) {
        this.testerRepository = testerRepository;
        this.testerLogRepository = testerLogRepository;
    }

    public TesterDTO addTester(TesterDTO testerDTO) {
        Tester tester = new Tester(testerDTO.getTesterName(), testerDTO.getTesterNumber());
        tester = testerRepository.save(tester);
        return new TesterDTO(tester.getId(), tester.getName(), tester.getNumber());
    }

    public TesterLogDTO addLog(TesterLogDTO testerLogDTO) {
        Tester tester = testerRepository.findOne(testerLogDTO.getTesterId());
        TesterLog testerLog = new TesterLog(tester, testerLogDTO.getSource(), testerLogDTO.getTarget());
        testerLog = testerLogRepository.save(testerLog);
        return new TesterLogDTO(testerLog.getId(), tester.getId(), testerLog.getSource(), testerLog.getTarget());
    }

    public List<Tester> getTesters() {
        return testerRepository.findWithSearch(null);
    }

    public Page<TesterDTO> getTestersWithPagination(Pageable pageable) {
        return testerRepository.findAllTestersWithPagination(pageable);
    }
}