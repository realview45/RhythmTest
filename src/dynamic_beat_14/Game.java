package dynamic_beat_14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementBar.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	//private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/Note01.png")).getImage();
	//private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSBImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRoutesemImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	//12
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	//13
	ArrayList<Note> noteList= new ArrayList<Note>();
	
	//14.5 노트수작업으로 안찍는법 gameMaker(게임제작모드)
	private boolean gameMaker=false;
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName; 
		this.difficulty=difficulty;
		this.musicTitle=musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		//14.5-2
		//gameMusic.start();
		//13
		//dropNotes(titleName);
	}
	//public ArrayList<String> keyList = new ArrayList<String>();
	//private ArrayList<String> keyList = new ArrayList<>(Arrays.asList("A", "S", "D", "F","SB","J","K","L",""));
/*
	public ArrayList<Image> routeList = new ArrayList<Image>();
	
	public Game() {
		routeList.add(noteRouteAImage);
		routeList.add(noteRouteSImage);
		routeList.add(noteRouteDImage);
		routeList.add(noteRouteFImage);
		routeList.add(noteRouteSBImage);
		routeList.add(noteRouteJImage);
		routeList.add(noteRouteKImage);
		routeList.add(noteRouteLImage);
		routeList.add(noteRoutesemImage);
	}
*/
	public void screenDraw(Graphics2D g) {	
		/*
		for(int i=0;i<5;i++) {
			g.drawImage(noteRouteLineImage, 15+104+104*i, 30, null);
			g.drawImage(noteRouteImage, 123+104*i, 30, null);
		}
		for(int i=5;i<10;i++) {
			g.drawImage(noteRouteImage, 119+104*i, 30, null);
			g.drawImage(noteRouteLineImage, 219+104*i, 30, null);
		}
		*/	
		g.drawImage(noteRouteLineImage, 15+104+104*0, 30, null);
		g.drawImage(noteRouteAImage, 123+104*0, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*1, 30, null);
		g.drawImage(noteRouteSImage, 123+104*1, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*2, 30, null);
		g.drawImage(noteRouteDImage, 123+104*2, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*3, 30, null);
		g.drawImage(noteRouteFImage, 123+104*3, 30, null);
		g.drawImage(noteRouteLineImage, 15+104+104*4, 30, null);
		g.drawImage(noteRouteSBImage, 123+104*4, 30, null);
		g.drawImage(noteRouteSBImage, 119+104*5, 30, null);
		g.drawImage(noteRouteLineImage,  219+104*5, 30, null);
		g.drawImage(noteRouteJImage, 119+104*6, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*6, 30, null);
		g.drawImage(noteRouteKImage, 119+104*7, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*7, 30, null);
		g.drawImage(noteRouteLImage, 119+104*8, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*8, 30, null);
		g.drawImage(noteRoutesemImage, 119+104*9, 30, null);
		g.drawImage(noteRouteLineImage, 219+104*9, 30, null); 	
		//g.drawImage(noteBasicImage, 123, 120, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		//13
		for(int i=0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		
		g.setColor(Color.white);
		//안티앨리어싱 적용되어 글자가 깨짐이 없이
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.ITALIC, 30));
		//12
		g.drawString(titleName,40,691);
		//g.drawString("KICKBACK arr by SunghaJung",40,691);
		g.drawString(difficulty, 1170, 691);
		
		g.setFont(new Font("Arial",Font.PLAIN,26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("A",  166,  609);
		g.drawString("S",  270,  609);
		g.drawString("D",  374,  609);
		g.drawString("F",  478,  609);
		g.drawString("Space Bar",  580,  609);
		g.drawString("J",  784,  609);
		g.drawString("K",  889,  609);
		g.drawString("L",  993,  609);
		g.drawString(";",  1097,  609);

		g.setFont(new Font("Elephant", Font.BOLD, 30));
		//점수판
		g.drawString("00000", 580, 691);
	
		
		
	}
	public void pressA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRouteA.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "A");
		}
	}
	public void pressS() {
		noteRouteSImage =new ImageIcon(Main.class.getResource("../images/noteRouteS.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "S");
		}
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRouteD.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "D");
		}
	}
	public void pressF() {
		noteRouteFImage =new ImageIcon(Main.class.getResource("../images/noteRouteF.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "F");
		}
	}
	public void pressSB() {
		noteRouteSBImage = new ImageIcon(Main.class.getResource("../images/noteRoute1.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "SB");
		}
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRouteJ.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "J");
		}
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRouteK.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "K");
		}
	}
	public void pressL() {
		noteRouteLImage =new ImageIcon(Main.class.getResource("../images/noteRouteL.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "L");
		}
	}
	public void presssem() {
		noteRoutesemImage = new ImageIcon(Main.class.getResource("../images/noteRoutesem.png")).getImage();
		if (gameMaker==true) {
			System.out.println(gameMusic.getTime() + "sem");
		}
	}
	public void releaseA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseS() {
		noteRouteSImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseSB() {
		noteRouteSBImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releaseL() {
		noteRouteLImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	public void releasesem() {
		noteRoutesemImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	@Override
	public void run() {//Game이라는 클래스로 만든 인스턴스가 run이라는 메서드를 사용할거임
		dropNotes();//14
	}
	//12
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	//13 14
	public void dropNotes() {
		//14.5-2
		
		Beat[] beats = null;
		if(titleName.equals("KICKBACK arr by Sungha Jung")) {
			//노트도달시간에 구애받지 않고 항상 첫번째 노트가 판정바에 적중하는 타이밍 유지가능
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap =400;
			beats = new Beat[] {
					new Beat(startTime, "SB"),
					new Beat(startTime+gap, "S"),
					new Beat(startTime+gap*2, "D"),
					new Beat(startTime+gap*4, "D"),
					new Beat(startTime+gap*6, "D"),
					new Beat(startTime+gap*8, "D"),
					new Beat(startTime+gap*10, "D"),
					new Beat(startTime+gap*12, "D")
			};
		}
		else if(titleName.equals("Dance of Marionette by HwaJong Kim")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "SB"),
			};
		}
		else if(titleName.equals("Crow by JinSan Kim")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "SB"),
			};
		}
		else if(titleName.equals("Rising Spirit arr by JaeHoon Jang")) {
			int startTime=1000;
			beats = new Beat[] {
					new Beat(startTime, "SB"),
			};
		}
		
		/*
		Beat[] beats= {
				new Beat(1000,"A"),//1초후 A떨어지게
				new Beat(2000,"S"),//2초후 B떨어지게
				new Beat(3000,"D"),
				new Beat(4000,"F"),
		};
		
		*/
		int i=0;
		//14.5-2 배열이 초기화되는 시간에서오는 시간격차를 줄일수있다
		gameMusic.start();
		
		//14.5-2 while안에 멈추는 조건넣어서 오류없애기
		while(i<beats.length && !isInterrupted()) {
			boolean dropped =false;
			//beat가 떨어지는시간대가 음악시간보다작다면
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();//떨어지는 쓰레드 시작 곡이재생되는 시점 실시간 파악해서 노트떨어뜨림
				noteList.add(note);
				i++;
				dropped=true;
			}
			if(!dropped) {//노트가 떨어지지않은경우는 조금 쉬고 노트를 떨어뜨림
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		//13 
		//Note note = new Note(227,0,"short");
		//14
		//Note note = new Note("short");	
		//note.start();
		//noteList.add(note);
		
		
		
		/*
		noteList.add(new Note(123,120,"short"));//A
		noteList.add(new Note(331,580,"short"));//D
		noteList.add(new Note(435,380,"short"));//F
		noteList.add(new Note(951,340,"short"));//L
		noteList.add(new Note(539,180,"long"));//SB
		noteList.add(new Note(227,325,"short"));//S
		noteList.add(new Note(743,340,"short"));//J
		noteList.add(new Note(847,305,"short"));//K
		noteList.add(new Note(1055,405,"short"));//;
		 */

	}
}
