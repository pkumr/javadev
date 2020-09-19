package com.interview.goog.process;

public class LicenseKeyFormatting {
    public static void main(String[] args){
        String S = "5F3Z-2e-9-w";
        int K = 4;
        System.out.println(new _482_LicenseKeyFormatting().licenseKeyFormatting(S, K));
    }
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
