package com.xebia.xke.algo.minimax.connect4;

import org.junit.Test;
import org.mockito.Mockito;

import static org.fest.assertions.Assertions.assertThat;

public class ConnectFourTest {

    @Test
    public void should_select_first_color_yellow() {
        for (int i = 0; i < 50; i++) {
            ConnectFour connectFour = new ConnectFour();
            assertThat(connectFour.getCurrentCounterColor()).isEqualTo(CounterColor.YELLOW);
        }

    }


    @Test
    public void should_be_ready_for_a_new_game() {
        ConnectFour connectFour = new ConnectFour();

        assertThat(connectFour.board.getNumberOfCounters()).isEqualTo(Integer.valueOf(0));
    }

    @Test
    public void should_end_game_true_if_board_is_full() {
        ConnectFour connectFour = new ConnectFour();
        Board board = Mockito.mock(Board.class);
        connectFour.board = board;

        Mockito.when(board.isFull()).thenReturn(true);

        assertThat(connectFour.isEndGame()).isTrue();
    }

    @Test
    public void should_end_game_false_if_board_is_not_full() {
        ConnectFour connectFour = new ConnectFour();
        Board board = Mockito.mock(Board.class);
        connectFour.board = board;

        Mockito.when(board.isFull()).thenReturn(false);

        assertThat(connectFour.isEndGame()).isFalse();
    }

    @Test
    public void should_be_a_valid_putting_counter() {
        ConnectFour connectFour = new ConnectFour();
        Board board = Mockito.mock(Board.class);
        connectFour.board = board;

        Mockito.when(board.putCounter(Mockito.anyInt(), Mockito.any(CounterColor.class))).thenReturn(1);

        Move move = connectFour.putCounter(0);

        assertThat(move.isValidMove()).isTrue();
    }

    @Test
    public void should_be_an_invalid_putting_counter() {
        ConnectFour connectFour = new ConnectFour();
        Board board = Mockito.mock(Board.class);
        connectFour.board = board;

        Mockito.when(board.putCounter(Mockito.anyInt(), Mockito.any(CounterColor.class))).thenReturn(-1);

        Move move = connectFour.putCounter(0);

        assertThat(move.isValidMove()).isFalse();
    }

    @Test
    public void should_counter_color_changed_if_the_last_round_is_correct() {
        ConnectFour connectFour = new ConnectFour();
        CounterColor counterColor = connectFour.getCurrentCounterColor();

        Move move = connectFour.putCounter(0);

        assertThat(move.isValidMove()).isTrue();
        assertThat(connectFour.board.getNumberOfCounters()).isEqualTo(1);
        assertThat(connectFour.getCurrentCounterColor()).isNotEqualTo(counterColor);


        move = connectFour.putCounter(1);

        assertThat(move.isValidMove()).isTrue();
        assertThat(connectFour.board.getNumberOfCounters()).isEqualTo(2);
        assertThat(connectFour.getCurrentCounterColor()).isEqualTo(counterColor);
    }

    @Test
    public void should_counter_color_not_changed_if_the_last_round_is_not_correct() {
        ConnectFour connectFour = new ConnectFour();
        CounterColor counterColor = connectFour.getCurrentCounterColor();

        Move move = connectFour.putCounter(0);

        assertThat(move.isValidMove()).isTrue();
        assertThat(connectFour.board.getNumberOfCounters()).isEqualTo(1);
        assertThat(connectFour.getCurrentCounterColor()).isNotEqualTo(counterColor);


        move = connectFour.putCounter(-1);

        assertThat(move.isValidMove()).isFalse();
        assertThat(connectFour.board.getNumberOfCounters()).isEqualTo(1);
        assertThat(connectFour.getCurrentCounterColor()).isNotEqualTo(counterColor);
    }



}
