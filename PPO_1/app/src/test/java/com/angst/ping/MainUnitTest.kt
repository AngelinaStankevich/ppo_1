package com.angst.ping.components

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GameTest {

  @Test
  fun testMoveRight() {
    val game = Game()
    game.moveRight()
    assertEquals(game.getRect().left, 11)
  }

  @Test
  fun testMoveLeft() {
    val game = Game()
    game.moveLeft()
    assertEquals(game.getRect().left, 9)
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
    assertFalse(game.checkBallCollision())
  }

  @Test
  fun testBallCollisionWithLeftWall() {
    val game = Game()
    game.moveBall()
    assertFalse(game.checkBallCollision())
    game.moveLeft()
    assertTrue(game.checkBallCollision())
  }
}

