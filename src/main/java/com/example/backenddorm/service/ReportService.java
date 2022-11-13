package com.example.backenddorm.service;

import com.example.backenddorm.pojo.Report;
import com.example.backenddorm.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    public ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReport(){
        return reportRepository.findAll();
    }
    public String addReport(Report report){
        try {
            reportRepository.insert(report);
            return "Add report successfully";
        }catch (Exception e){
            return "add report failed";
        }
    }
    public String updateReport(Report report){
        try {
            reportRepository.save(report);
            return "update report successfully";
        }catch (Exception e){
            return "update report failed";
        }
    }
}
