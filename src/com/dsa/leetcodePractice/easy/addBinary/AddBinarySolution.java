package com.dsa.leetcodePractice.easy.addBinary;

public class AddBinarySolution {

    public static void main(String[] args){
        AddBinarySolution solution = new AddBinarySolution();
        System.out.println(solution.addBinary("1","0"));
    }

    public String addBinary(String a, String b) {

        char reminder = '0';
        String output = "";
        int aCounter = a.length()-1;
        int bCounter = b.length()-1;
        while(aCounter >=0 || bCounter >= 0 || reminder != '0'){
          /*  String sum = getAddition(reminder,
                    (aCounter>=0)?a.charAt(aCounter--):'0',
                    (bCounter>=0)?b.charAt(bCounter--):'0'); */
            String sum = getAddition(""+reminder+
                    ((aCounter>=0)?a.charAt(aCounter--):'0')+
                    ((bCounter>=0)?b.charAt(bCounter--):'0'));
            if(sum.length()==2){
                reminder = sum.charAt(0);
                output = sum.charAt(1) + output;
            } else {
                reminder = '0';
                output = sum.charAt(0) + output;
            }

        }
        return output;

    }

    private String getAddition(char reminder, char n1, char n2){
        if(reminder=='0' && n1=='0' && n2=='0'){
            return "0";
        } else if (reminder=='0' && n1=='0' && n2=='1'){
            return "1";
        } else if (reminder=='0' && n1=='1' && n2=='0'){
            return "1";
        } else if (reminder=='0' && n1=='1' && n2=='1'){
            return "10";
        } else if (reminder=='1' && n1=='0' && n2=='0'){
            return "1";
        } else if (reminder=='1' && n1=='0' && n2=='1'){
            return "10";
        } else if (reminder=='1' && n1=='1' && n2=='0'){
            return "10";
        } else if (reminder=='1' && n1=='1' && n2=='1'){
            return "11";
        }
        return "0";
    }

    private String getAddition(String key){
        switch(key) {
            case "000":
                break;
            case "001":
            case "100":
            case "010":
                return "1";
            case "101":
            case "011":
            case "110":
                return "10";
            case "111":
                return "11";
            default:
                return "0";
        }

    return "0";
    }
}
