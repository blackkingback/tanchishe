package tanchishe;

import java.util.LinkedList;
import java.util.Random;

public class She {
	private LinkedList<Node> body;
	private int direction;
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int RIGHT = 3;
	public static final int DOWN = 4;
	public static final int SLOW = 500;
	public static final int MIDDLE = 300;
	public static final int HIGH = 150;
	public boolean pause = false;
	public int rest = 100;
	private Node food;
	public int speed;
	private boolean Judge = false;
	public int grade = 0;
	Cnotrollor cr2 = new Cnotrollor();
	

	public void madeFood() {
		food = new Node();
		Random rd = new Random();
		
		food.setX(rd.nextInt((GamePnel.WIDTH) / Node.WIDTH) * 20);
		food.setY(rd.nextInt((GamePnel.HEIGHT) / Node.HEIGHT) * 20);
			Foodchongdie();

	}
	

	private void Foodchongdie() {
		boolean fk=true;
		Random rd = new Random();
		for(int i=0;i<body.size();i++)
		{	
		
			if(food.getX()==body.get(i).getX()&&food.getY()==body.get(i).getY())
			{
				fk=false;
			}
		}
		if(fk==false)
		{
			food.setX(rd.nextInt((GamePnel.WIDTH) / Node.WIDTH) * 20);
			food.setY(rd.nextInt((GamePnel.HEIGHT) / Node.HEIGHT) * 20);
		}
		
	}


	public Node getFood() {
		return food;
	}

	public She() {
		// initSnake();
	}

	public void initSnake() {
		body = new LinkedList<>();
		body.addLast(new Node(100, 40));
		body.addLast(new Node(80, 40));
		body.addLast(new Node(60, 40));
		direction = RIGHT;
		speed = SLOW;
		grade=0;
		
		madeFood();
	}

	public void changedirection(int direction) {
		if (direction % 2 != this.direction % 2) {
			this.direction = direction;
		}
	}

	public LinkedList<Node> getbody() {
		return body;
	}

	public void move() {
		eatfood();
		eatbody();
		Node tail = body.removeLast();
		Node head = body.getFirst();
		int x = head.getX();
		int y = head.getY();

		switch (direction) {
		case LEFT:
			x -= Node.WIDTH;
			break;
		case RIGHT:
			x += Node.WIDTH;
			break;
		case UP:
			y -= Node.HEIGHT;
			break;
		case DOWN:
			y += Node.HEIGHT;
			break;

		}
		tail.setX(x);
		tail.setY(y);
		body.addFirst(tail);
	}

	public void eatfood() {
		Node head = body.getFirst();
		int x = head.getX();
		int y = head.getY();
		if (((x + 20) == food.getX()) && (y == food.getY()) && (direction == RIGHT))// 从左往右
		{
			body.addFirst(food);
			madeFood();
			Judge = true;

		} else if ((x == food.getX()) && (y == food.getY() + 20) && (direction == UP))// 从下往上
		{
			body.addFirst(food);
			madeFood();
			Judge = true;

		} else if (((x - 20) == food.getX()) && (y == food.getY()) && (direction == LEFT))// 从右往左
		{
			body.addFirst(food);
			madeFood();
			Judge = true;

		} else if ((x == food.getX()) && ((y + 20) == food.getY()) && (direction == DOWN))// 从上往下
		{
			body.addFirst(food);
			madeFood();
			Judge = true;

		}

	}
	public void eatbody(){
		Node head=body.getFirst();
		int x = head.getX();
		int y = head.getY();
		for(int i=0;i<body.size();i++)
		{
			body.get(i);
			if (((x + 20) == body.get(i).getX()) && (y ==body.get(i).getY()) && (direction == RIGHT))// 从左往右
			{
				initSnake();

			} else if ((x ==  body.get(i).getX()) && (y ==  body.get(i).getY() + 20) && (direction == UP))// 从下往上
			{
				initSnake();


			} else if (((x - 20) ==  body.get(i).getX()) && (y ==  body.get(i).getY()) && (direction == LEFT))// 从右往左
			{
				initSnake();


			} else if ((x == body.get(i).getX()) && ((y + 20) == body.get(i).getY()) && (direction == DOWN))// 从上往下
			{
				initSnake();

			}
		}
	}

	public int Gameover() {
		Node head = body.getFirst();
		int x = head.getX();
		int y = head.getY();
		if ((x >= 0) && (x <= GamePnel.WIDTH) && (y == 0)) {
			if (direction == UP)
				return -1;
			else
				return 100;
		} else if ((x >= 0) && (x <= GamePnel.WIDTH) && ((y + 20) == GamePnel.HEIGHT)) {
			if (direction == DOWN) {
				return -1;
			} else
				return 100;
		} else if ((x == 0) && ((y >= 0) && (y <= GamePnel.HEIGHT - 20))) {
			if (direction == LEFT) {
				return -1;
			} else
				return 100;
		} else if ((x + 20 == GamePnel.WIDTH) && ((y >= 0) && (y <= GamePnel.HEIGHT - 20))) {
			if (direction == RIGHT) {
				return -1;
			} else
				return 100;
		} else
			return 100;

	}

	public int jiafen() {
		if (Judge == true) {
			Judge = false;
			return 1;

		} else
			return -1;

	}

}
