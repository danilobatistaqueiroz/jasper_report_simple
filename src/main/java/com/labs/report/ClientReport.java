package com.labs.report;

import java.io.File;
import java.util.List;

import com.labs.model.Client;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ClientReport 
{
	private String path;
	
	private String pathToReportPackage;
	
	public ClientReport() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "com/labs/jasper/";
		System.out.println(path);
	}
	
	
	public void generate(List<Client> clients) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Clients.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clients));
		
		File filePath = new File("f:/java/jasperreports/clients.pdf");

		JasperExportManager.exportReportToPdfFile(print, filePath.getAbsolutePath());		
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}