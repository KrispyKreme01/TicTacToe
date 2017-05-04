package com.mattf.tictactoe;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class TicTacToe extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -251545041651690561L;
	//
	boolean running = false;
	private Thread thread;

	public TicTacToe() {
		new Window(500, 500, "Matthew Freedberg Tic Tac Toe", this);
	}

	public static void main(String[] args) {
		new TicTacToe();

	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 6;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				delta--;
			}

			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// fps = "FPS: " + frames;
				frames = 0;
			}

		}
		stop();

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 500, 500);
		
		g.setColor(Color.WHITE);
		g.fillOval(1, 1, 100, 100);
		g.drawLine(0, 0, 500, 500);

		g.dispose();
		bs.show();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running = false;

	}

}