package model;

import java.util.ArrayList;
import java.util.List;


public class Employee implements Deduction {
    private final String employeeNumber;
    private final String lastName;
    private final String firstName;
    private final String employeeBirthday;
    private final String employeeAddress;
    private final String contactInfo;
    private final String sssNumber;
    private final String philhealthNumber;
    private final String tinNumber;
    private final String pagibigNumber;
    private final String employeeStatus;
    private final String employeePosition;
    private final String employeeBoss;
    private final String employeeSalarybase;
    private final String riceSubsidy;
    private final String phoneAllowance;
    private final String clothingAllowance;
    private final String grossSemiRate;
    private final String hourlyRate;
    
    public Employee(
                        String employeeNumber,
                        String lastName,
                        String firstName,
                        String employeeBirthday,
                        String employeeAddress,
                        String contactInfo,
                        String sssNumber,
                        String philhealthNumber,
                        String tinNumber,
                        String pagibigNumber,
                        String employeeStatus,
                        String employeePosition,
                        String employeeBoss,
                        String employeeSalarybase,
                        String riceSubsidy,
                        String phoneAllowance,
                        String clothingAllowance,
                        String grossSemiRate,
                        String hourlyRate
                ) 
    {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.employeeBirthday = employeeBirthday;
        this.employeeAddress = employeeAddress;
        this.contactInfo = contactInfo;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.employeeStatus = employeeStatus;
        this.employeePosition = employeePosition;
        this.employeeBoss = employeeBoss;
        this.employeeSalarybase = employeeSalarybase;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiRate = grossSemiRate;
        this.hourlyRate = hourlyRate;
    }
    
    public String getEmployeeNumber() { return employeeNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getBirthday() { return employeeBirthday; }
    public String getAddress() { return employeeAddress; }
    public String getContactInfo() { return contactInfo; }
    
    public String getSssNumber() { return sssNumber; }
    public String getPhilhealthNumber() { return philhealthNumber; }
    public String getTinNumber() { return tinNumber; }
    public String getPagibigNumber() { return pagibigNumber; }
    public String getStatus() { return employeeStatus; }
    public String getPosition() { return employeePosition; }
    public String getSupervisor() { return employeeBoss; }

    public String getBaseSalary() { return employeeSalarybase; }
    public String getRiceSubsidy() { return riceSubsidy; }
    public String getPhoneAllowance() { return phoneAllowance; }
    public String getClothingAllowance() { return clothingAllowance; }
    public String getSemiRate() { return grossSemiRate; }
    public String getHourlyRate() { return hourlyRate; }

    // CSV conversion methods
    public String toCsvString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
            employeeNumber,
            lastName,
            firstName,
            employeeBirthday,
            employeeAddress,
            contactInfo,
            sssNumber,
            philhealthNumber,
            tinNumber,
            pagibigNumber,
            employeeStatus,
            employeePosition,
            employeeBoss,
            employeeSalarybase,
            riceSubsidy,
            phoneAllowance,
            clothingAllowance,
            grossSemiRate,
            hourlyRate
        );
    }
    
    public static Employee fromCsvString(String csvLine) {
        String[] parts = csvLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        if (parts.length != 19) {
            throw new IllegalArgumentException("Invalid CSV format: expected 19 fields, got " + parts.length);
        }
        
        try {
            Employee emp = new Employee(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim(),
                parts[4].trim(),
                parts[5].trim(),
                parts[6].trim(),
                parts[7].trim(),
                parts[8].trim(),
                parts[9].trim(),
                parts[10].trim(),
                parts[11].trim(),
                parts[12].trim(),
                parts[13].trim(),
                parts[14].trim(),
                parts[15].trim(),
                parts[16].trim(),
                parts[17].trim(),
                parts[18].trim()
            );
            
            return emp;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing CSV line: " + e.getMessage());
        }
    }
   
    @Override
    public double calc_witholding(double grossPay) {
        if (grossPay <= 20832) {
            return 0.0;
        } 
        else if (grossPay <= 33333) {
            return (grossPay - 20833) * 0.20;
        } 
        else if (grossPay <= 66667) {
            return 2500 + (grossPay - 33333) * 0.25;
        } 
        else if (grossPay <= 166667) {
            return 10833 + (grossPay - 66667) * 0.30;
        } 
        else if (grossPay <= 666667) {
            return 40833.33 + (grossPay - 166667) * 0.32;
        } 
        else {
            return 200833.33 + (grossPay - 666667) * 0.35;
        }
    }
    
    @Override
    public double calc_SSS(double grossPay) {
        double[][] sssBrackets = {
            {0, 3249.99, 135.00},
            {3250, 3749.99, 157.50},
            {3750, 4249.99, 180.00},
            {4250, 4749.99, 202.50},
            {4750, 5249.99, 225.00},
            {5250, 5749.99, 247.50},
            {5750, 6249.99, 270.00},
            {6250, 6749.99, 292.50},
            {6750, 7249.99, 315.00},
            {7250, 7749.99, 337.50},
            {7750, 8249.99, 360.00},
            {8250, 8749.99, 382.50},
            {8750, 9249.99, 405.00},
            {9250, 9749.99, 427.50},
            {9750, 10249.99, 450.00},
            {10250, 10749.99, 472.50},
            {10750, 11249.99, 495.00},
            {11250, 11749.99, 517.50},
            {11750, 12249.99, 540.00},
            {12250, 12749.99, 562.50},
            {12750, 13249.99, 585.00},
            {13250, 13749.99, 607.50},
            {13750, 14249.99, 630.00},
            {14250, 14749.99, 652.50},
            {14750, 15249.99, 675.00},
            {15250, 15749.99, 697.50},
            {15750, 16249.99, 720.00},
            {16250, 16749.99, 742.50},
            {16750, 17249.99, 765.00},
            {17250, 17749.99, 787.50},
            {17750, 18249.99, 810.00},
            {18250, 18749.99, 832.50},
            {18750, 19249.99, 855.00},
            {19250, 19749.99, 877.50},
            {19750, 20249.99, 900.00},
            {20250, 20749.99, 922.50},
            {20750, 21249.99, 945.00},
            {21250, 21749.99, 967.50},
            {21750, 22249.99, 990.00},
            {22250, 22749.99, 1012.50},
            {22750, 23249.99, 1035.00},
            {23250, 23749.99, 1057.50},
            {23750, 24249.99, 1080.00},
            {24250, 24749.99, 1102.50},
            {24750, Double.MAX_VALUE, 1125.00} // Over 24,750
        };

        for (double[] bracket : sssBrackets) {
            if (grossPay >= bracket[0] && grossPay <= bracket[1]) {
                return bracket[2];
            }
        }

        return 0.0; // fallback, but it shouldn't happen i think
    }
    
    @Override
    public double calc_philhealth(double grossPay) {
        return grossPay * Constants.PHILHEALTH_RATE;
    }
    
    @Override
    public double calc_pagibig(double grossPay) {
        if (grossPay >= 1000 && grossPay <= 1500) {
            return grossPay * Constants.PAGIBIG_RATE_LO;  // 1% low rate
        } 
        else if (grossPay > 1500) {
            return grossPay * Constants.PAGIBIG_RATE_HI;  // 2% high rate
        } 
        else {
            return 0.0; // Below 1,000: no contribution probably wont happen for MotorPH employees
        }
    }
    
}
