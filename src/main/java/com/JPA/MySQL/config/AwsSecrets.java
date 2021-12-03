/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
The AWS configuration secret variables
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsSecrets {

    private String username;
    private String password;
    private String host;
    private String engine;
    private String port;
    private String dbInstanceIdentifier;

}
