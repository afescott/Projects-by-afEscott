package uk.ac.bmth.aprog.task01;

public class Task01 {


    private static void Problem_Letters_To_Numbers() {
        System.out.println("Problem NumbersToLetters:");
        System.out.println("==========");
        String nameOfUnit;
        String[] digit = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] tenToTwenty = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"twenty", "thirty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] hundreds = {"onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred", "sixhundred", "sevenhundred",
                "eighthundred", "ninehundred"};
        int count = 0;
        int countTenToTwenty = 0;
        int countHundredsTenToTwenty = 0;
        int countHundredsZeroToTen = 0;
        int hundredCounter = 0;
        int unitLength = 0;
        int countHundreds = 0;
        int countHundredsTens = 0;
        int tenCount = 0;
        int letterAmount = 0;
        for (int i = 0; i <= 999; i++) {
            if (i <= 9) {

                nameOfUnit = digit[i];
                unitLength = nameOfUnit.length();
                System.out.println(nameOfUnit);

                letterAmount = letterAmount + unitLength;


            } else if (i >= 11 && i <= 19) {


                String unitNameo = tenToTwenty[count];
                unitLength = unitNameo.length();
                System.out.println(unitNameo);
                System.out.println(unitLength);
                count = count + 1;
                letterAmount = letterAmount + unitLength;


            } else if (i >= 20 && i <= 28) {

                String unitNameoo = tens[countTenToTwenty];

                for (int incrementer = 0; incrementer <= 9; incrementer++) {

                    nameOfUnit = digit[incrementer]; //count 2 = 0;

                    System.out.println(unitNameoo);
                    System.out.println(nameOfUnit);
                    unitLength = nameOfUnit.length();
                    letterAmount = letterAmount + unitLength;
                }
                countTenToTwenty = countTenToTwenty + 1;

            } else if (i >= 29) {


                for (int incrementer = 0; incrementer <= 100; incrementer++) { //units


                    String hundredsUnits;

                    if (tenCount <= 10) {
                        hundredsUnits = hundreds[hundredCounter];
                        nameOfUnit = digit[countHundredsZeroToTen]; //if count is 0 access 0-10

                        System.out.println(hundredsUnits);
                        System.out.println(nameOfUnit);
                        unitLength = nameOfUnit.length();
                        letterAmount = letterAmount + unitLength;
                        countHundredsZeroToTen = countHundredsZeroToTen + 1;
                        tenCount = tenCount + 1;
                    } else if (tenCount <= 19) {
                        hundredsUnits = hundreds[hundredCounter];
                        nameOfUnit = tenToTwenty[countHundredsTenToTwenty];
                        unitLength = nameOfUnit.length();
                        System.out.println(hundredsUnits);
                        System.out.println(nameOfUnit);

                        countHundredsTenToTwenty = countHundredsTenToTwenty + 1;
                        tenCount = tenCount + 1;
                        letterAmount = letterAmount + unitLength;

                    } else {


                        hundredsUnits = hundreds[hundredCounter];
                        nameOfUnit = tens[countHundredsTens];

                        String digitName = digit[countHundreds];
                        int digitLength = digitName.length();
                        System.out.println(hundredsUnits);
                        System.out.println(nameOfUnit);
                        System.out.println(digitName);

                        unitLength = digitName.length();
                        letterAmount = letterAmount + unitLength + digitLength;

                        countHundreds = countHundreds + 1;
                        System.out.println(countHundreds);


                        if (countHundreds == 10) {
                            countHundreds = 0;

                            countHundredsTens = countHundredsTens + 1;
                            if (countHundredsTens == 9) { //if there has been 10 multiples of ten

                                countHundredsTens = 0;
                                System.out.println("reached 100");

                                hundredCounter = hundredCounter + 1;
                                countHundredsZeroToTen = 0;
                                countHundredsTenToTwenty = 0;
                                tenCount = 0;


                                if (hundredCounter == 9) {
                                    System.out.println(1000);
                                    letterAmount = letterAmount + 8;
                                    System.out.println("Count Reached, Letter Total (without spaces)");
                                    System.out.println(letterAmount);
                                    break;
                                }

                            }
                        }

                    }


                }
            }
        }

    }


    public static void main(String[] args) {
        Problem_Letters_To_Numbers();
        System.out.println();

    }

}
