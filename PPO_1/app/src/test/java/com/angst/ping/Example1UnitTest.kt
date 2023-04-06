package com.angst.ping.components

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GameTest {

  @Test
  fun testInitialPosition() {
    val game = Game()
    val rect = game.getRect()
    assertEquals(10, rect.left)
    assertEquals(450, rect.top)
    assertEquals(210, rect.right)
    assertEquals(470, rect.bottom)
  }

  @Test
  fun testMoveRight() {
    val game = Game()
    game.moveRight()
    assertEquals(11, game.getRect().left)
  }

  @Test
  fun testMoveLeft() {
    val game = Game()
    game.moveLeft()
    assertEquals(9, game.getRect().left)
  }

  @Test
  fun testBallCollision() {
    val game = Game()
    game.moveBall()
    game.moveBall()
    game.moveBall()
    game.moveBall()
    assertTrue(game.checkBallCollision())
  }

  @Test
  fun testScoreIncrease() {
    val game = Game()
    game.moveBall()
    assertEquals(1, game.getScore())
    game.moveBall()
    assertEquals(1, game.getScore())
    game.moveBall()
    assertEquals(2, game.getScore())
  }

  @Test
  fun testGameRestart() {
    val game = Game()
    game.moveBall()
    game.moveBall()
    game.moveBall()
    game.restartGame()
    assertEquals(0, game.getScore())
    val rect = game.getRect()
    assertEquals(10, rect.left)
    assertEquals(450, rect.top)
    assertEquals(210, rect.right)
    assertEquals(470, rect.bottom)
    assertFalse(game.isGameOver())
  }
}

