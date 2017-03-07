package com.miles.controller;

import com.miles.model.Company;
import com.miles.model.CompanyWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhavi on 3/7/2017.
 */
@RestController
@RequestMapping("/company")
@Path("/company")
public class CompanyController {

    private static Map<String,Company> companyMap = new HashMap<>();
    RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    String url ;

    @RequestMapping(value = "/{companyName}",produces = "application/json")
    @GET
    public Company getCompanyByName(@PathVariable("companyName") String companyName){
        if(companyMap.size() == 0 ){
            loadCompanyDetails();
        }
        System.out.println("company to look for is " + companyName);
        companyName = companyName.toLowerCase();
        if(companyMap.containsKey(companyName)){
            return companyMap.get(companyName);
        } else {
            System.out.println("company to look for is " + companyName);
            Collection<Company> companyList = companyMap.values();
            for(Company comp: companyList){
                if(comp.getCompanyName().contains(companyName) || comp.getCompanyPopularName().contains(companyName) ||
                        (comp.getBrandName() !=null && comp.getBrandName().contains(companyName))){
                    return comp;
                }
            }
        }

        throw new com.miles.exception.ResourceNotFoundException();
    }

    private void loadCompanyDetails(){
        System.out.println("loading company details ");
        Map<String, String> env = System.getenv();
        url = env.get("GET_ALL_COMPANY_URL");
        ResponseEntity<CompanyWrapper> responseEntity = restTemplate.getForEntity(url, CompanyWrapper.class);
        CompanyWrapper wrapper = responseEntity.getBody();
        System.out.println("number of companies" + wrapper.getResult().size());
        if (null != wrapper) {
            wrapper.getResult().forEach(company -> {
                System.out.println(" setting company details");
                company.setCompanyName(company.getCompanyName().toLowerCase());
                if (null != company.getCompanyPopularName()) {
                    company.setCompanyPopularName(company.getCompanyPopularName().toLowerCase());
                }
                if (null != company.getBrandName()){
                    company.setBrandName(company.getBrandName().toLowerCase());
                }
                companyMap.put(company.getCompanyName().toLowerCase(), company);
            });
        }
    }

}
