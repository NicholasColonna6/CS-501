/*
 * Nicholas Colonna & Evan Gutch
 * Group 12
 * Assignment 6
 * Exercise 10.13
 * CS 501WS
 * "I pledge my honor that I have abided by the Stevens Honor System." -ncolonna  -egutch
 */

public class MyRectangle2D {
	private double x, y;	//where center of rectangle is
	private double width, height;  //size of rectangle
	
	//default constructor
	MyRectangle2D(){
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.height = 1;
	}
	
	//main constructor
	MyRectangle2D(double x_, double y_, double w, double h){
		this.x = x_;
		this.y = y_;
		this.width = w;
		this.height = h;
	}
	
	//Getters
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	double getWidth() {
		return width;
	}
	
	double getHeight() {
		return height;
	}
	
	//Setters
	void setX(double x_) {
		this.x = x_;
	}
	
	void setY(double y_) {
		this.y = y_;
	}
	
	void setWidth(double w) {
		this.width = w;
	}
	
	void setHeight(double h) {
		this.height = h;
	}
	
	//function calculates area of rectangle
	double getArea() {
		return this.height * this.width;
	}
	
	//function calculates perimeter of rectangle
	double getPerimeter() {
		return 2 * this.height + 2 * this.width;
	}
	
	//function returns if specified points is inside rectangle
	boolean contains(double x, double y) {
		//checks if x is contained
		if((this.x - this.width / 2) > x || (this.x + this.width / 2) < x) {
			return false;
		}
		//checks if y is contained
		if((this.y - this.height / 2) > y || (this.y + this.height / 2) < y) {
			return false;
		}
		
		return true;
	}
	
	//function returns if specified rectangle is inside this rectangle
	boolean contains(MyRectangle2D r) {
		//checks if left and right sides are contained
		if((this.x - this.width / 2) < (r.getX() - r.getWidth() / 2) && (this.x + this.width / 2) > (r.getX() + r.getWidth() / 2)) {
			//checks if top and bottom sides are contained
			if((this.y - this.height / 2) < (r.getY() - r.getHeight() / 2) && (this.y + this.height / 2) > (r.getY() + r.getHeight() / 2)) {
				return true;
			}
		}

		return false;
	}
	
	//function returns if specified rectangle abuts with this rectangle
	boolean abuts(MyRectangle2D r) {
		//if r is inside this, return false (no overlaps)
		if(this.contains(r) == true) {
			return false;
		}
		
		//left side of base and right of test check
		if((this.x - this.width / 2) == (r.getX() + r.getWidth() / 2)) {
			if((this.y - this.height / 2) <= (r.getY() + r.getHeight() / 2) && (this.y + this.height / 2) >= (r.getY() - r.getHeight() / 2)) {
				return true;
			}	
		}
		
		//right side of base and left of test check
		if((this.x + this.width / 2) == (r.getX() - r.getWidth() / 2)) {
			if((this.y - this.height / 2) <= (r.getY() + r.getHeight() / 2) && (this.y + this.height / 2) >= (r.getY() - r.getHeight() / 2)) {
				return true;
			}
		}

		//bottom side of base and top of test check
		if((this.y - this.height / 2) == (r.getY() + r.getHeight() / 2)) {
			if((this.x - this.width / 2) <= (r.getX() + r.getWidth() / 2) && (this.x + this.width / 2) >= (r.getX() - r.getWidth() / 2)) {
				return true;
			}
		}
		
		//top side of base and bottom of test check
		if((this.y + this.height / 2) == (r.getY() - r.getHeight() / 2)) {
			if((this.x - this.width / 2) <= (r.getX() + r.getWidth() / 2) && (this.x + this.width / 2) >= (r.getX() - r.getWidth() / 2)) {
				return true;
			}
		}
		
		return false;
	}
	
	//function returns if specified rectangle overlaps with this rectangle
	boolean overlaps(MyRectangle2D r) {
		if(this.abuts(r) == true) {
			return false;
		}
		
		//checks if left side of this is greater than right side of r
		//checks if right side of this is less than left side of r
		if((this.x - this.width / 2) > (r.getX() + r.getWidth() / 2) || (this.x + this.width / 2) < (r.getX() - r.getWidth() / 2)) {
			//checks if top side of this is less than bottom side of r
			//checks if bottom side of this is greater than top side of r
			if((this.y - this.height / 2) > (r.getY() + r.getHeight() / 2) || (this.y + this.height / 2) < (r.getY() - r.getHeight() / 2)) {
				return false;
			}		
		}

		return true;
	}
	

}
