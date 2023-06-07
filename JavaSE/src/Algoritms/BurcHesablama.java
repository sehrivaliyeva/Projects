package Algoritms;

import java.util.Scanner;

public class BurcHesablama {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Ayı daxil edin (1,2 və s) :");
		int ay=scan.nextInt();
		System.out.print("Günü daxil edin : ");
		int gun=scan.nextInt();
		
		if((ay>12 || ay<0)|| (gun<0 || gun>31)||(ay==1 && gun>31)||(ay==2 && gun>29)||
		(ay==3 && gun>31)||(ay==4 && gun>30)||(ay==5 && gun>31)||(ay==6 && gun>30)||(ay==7 && gun>31)||
		(ay==8 && gun>31)||(ay==9 && gun>30)||(ay==10 && gun>31)||(ay==11 && gun>30)||(ay==12 && gun>31)) {
			System.err.println("Yanlış məlumat daxil etmisiniz !!!");
		} else {
		
		
		if((ay==12 && gun>=22)||(ay==1 && gun<=19)) {
			System.out.println("Oğlaq bürcüdür");
		}else if((ay==1 && gun>=20)||(ay==2 && gun<=18)) {
			System.out.println("Dolça bürcüdür");
		}else if((ay==2 && gun>=19)||(ay==3 && gun<=20)) {
			System.out.println("Balıq bürcüdür");
		}else if((ay==3 && gun>=21)||(ay==4 && gun<=19)) {
			System.out.println("Qoç bürcüdür");
		}else if((ay==4 && gun>=20)||(ay==5 && gun<=20)) {
			System.out.println("Buğa bürcüdür");
		}else if((ay==5 && gun>=21)||(ay==6 && gun<=20)) {
			System.out.println("Əkizlər bürcüdür");
		}else if((ay==6 && gun>=21)||(ay==7 && gun<=22)) {
			System.out.println("Xərçəng bürcüdür");
		}else if((ay==7 && gun>=23)||(ay==8 && gun<=22)) {
			System.out.println("Şir bürcüdür");
		}else if((ay==8 && gun>=23)||(ay==9 && gun<=22)){
			System.out.println("Qız bürcüdür");
		}else if((ay==9 && gun>23)||(ay==10 && gun<=22)){
			System.out.println("Tərəzi bürcüdür");
		}else if((ay==10 && gun>23)||(ay==11 && gun<=21)){
			System.out.println("Əqrəb bürcüdür");
		}else if((ay==11 && gun>=22)||(ay==12 && gun<=21)) {
			System.out.println("Oxatan bürcüdür");
		}else {
			System.out.println("Tapılmadı");
		}
		}
}

	}


