package com.mattf.tictactoe;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{


	private static final long serialVersionUID = -3597010261885799623L;

	public Window(int width, int height, String title, TicTacToe tictactoe) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(tictactoe);
		frame.setVisible(true);
		tictactoe.start();
		
	}

}
