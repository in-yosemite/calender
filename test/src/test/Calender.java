//Copyright [2017] [Hansung Universtiy]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.


package test;

import java.util.Scanner;

public class Calender {

	//This is Calender Program.
	//Input data is only Integer type. 
	public static void main(String[] args) {
		   System.out.println("년도를 입력하세요");
	        Scanner scanner1 = new Scanner(System.in);
	        int year = scanner1.nextInt();

	        System.out.println("월를 입력하세요");
	        Scanner scanner2 = new Scanner(System.in);
	        int month = scanner2.nextInt();

	        System.out.println("날를 입력하세요");
	        Scanner scanner3 = new Scanner(System.in);
	        int day = scanner1.nextInt();

	        int[] max_value_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //1월 부터 12월 까지 최대 날짜 값을 저장하는 배열 생성
	        int sum_month_temp = 0; // 달의 합계를 나타내는 임시 변수 생성
	        int total_days = 0; // 1년 1월 1일부터 입력한 날까지의 총 날의 개수

	        total_days += (year - 1) + 365;
	        total_days += year / 4 - year / 100 + year / 400;

	        int four_multiple = year % 4; //4의 배수를 확인하기 위한 변수
	        int hundred_multiple = year % 100; // 100의 배수를 확인하기 위한 변수

	        //윤년을 확인하는 조건문
	        if (four_multiple == 0 && hundred_multiple == 0) {
	            if (month == 1 || month == 2) {
	                total_days--;
	                max_value_month[1] = 29; //윤년이므로 2월달 날짜의 최대값을 29로 설정
	            }
	        } else if (four_multiple == 0 && hundred_multiple != 0) {
	            if (month == 1 || month == 2) {
	                total_days--;
	                max_value_month[1] = 29; //윤년이므로 2월달 날짜의 최대값을 29로 설정
	            }
	        } else {
	        }//윤년이 아님


	        if (month ==1 ){//1월보다 이전 달은 없으므로 더해줄 달의 날짜가 없음
	            sum_month_temp = 0;
	        }
	        else{//1월이 아닌 달은, 이전 달의 더해줄 날짜가 있음
	            for(int i=0; i< month -1; i++){
	                sum_month_temp += max_value_month[i];

	                total_days += sum_month_temp = day; // 주어진 월과 일까지의 날 수를 더한다
	            }
	        }


	        System.out.println("   "+"일     "+"월    "+"화    "+"수    "+"목    "+"금    "+"토     " );

	        int check_day_of_the_week = (total_days+2) % 7; // 기준년인 1년 1월 1일이 수요일이므로 2를 더한뒤, 요일을 확인하는 변수 생성

	        for(int i=0;i<check_day_of_the_week; i++){ // 공백을 위한 조건문 설정
	            System.out.printf("     ");
	        }

	        for(int j = 1;j<=max_value_month[month-1];j++){
	            if(day == j){
	                System.out.printf("%4d"+"*",j); // 현재 검색한 날짜를 표시하기 위한 조건문 설정
	            }
	            else{
	                System.out.printf("%4d"+" ",j);
	            }
	            if((j+check_day_of_the_week)%7 == 0 ) System.out.println();
	        }




	}

}
