package com.aurionpro.mapping.dto;

import java.sql.Date;
import java.util.List;
import com.aurionpro.mapping.entity.enums.ClientKycStatus;
import com.aurionpro.mapping.entity.enums.ClientStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private int clientId;
    private String companyName;
    private Long registrationNumber;
    private String contactPerson;
    private String contactEmail;
    private Long contactNumber;
    private String address;
    private ClientStatus status;
    private Date creationDate;
    private ClientKycStatus clientKycStatus;

    @JsonManagedReference
    private List<EmployeeDTO> employees;
}
