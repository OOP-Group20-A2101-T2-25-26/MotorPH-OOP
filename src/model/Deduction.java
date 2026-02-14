package model;
/**
 *
 * @author Vladimir Bernardo
 */
public interface Deduction {
    double calc_witholding(double grossPay);
    double calc_SSS(double grossPay);
    double calc_philhealth(double grossPay);
    double calc_pagibig(double grossPay);
}
