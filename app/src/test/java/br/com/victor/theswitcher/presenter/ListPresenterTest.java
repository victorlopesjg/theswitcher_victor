package br.com.victor.theswitcher.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.victor.theswitcher.app.listroom.ListContract;
import br.com.victor.theswitcher.model.Room;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;

/**
 * Created by Victor Oliveira on 06/12/18.
 * github: victorlopejg
 */

@RunWith(MockitoJUnitRunner.class)
public class ListPresenterTest {

    @Mock
    private ListContract.View mListView;

    private ListPresenterFake mListPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mListPresenter = new ListPresenterFake(mListView);
    }

    @Test
    public void signInAndShowProgress() {
        mListPresenter.listRoom();
        verify(mListView).showList(anyListOf(Room.class));
    }

}
