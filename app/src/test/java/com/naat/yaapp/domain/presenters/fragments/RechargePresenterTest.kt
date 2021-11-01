package com.naat.yaapp.domain.presenters.fragments

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import com.naat.yaapp.presentation.fragments.views.RechargeView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.invocation.InvocationOnMock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.stubbing.Answer

@RunWith(MockitoJUnitRunner::class)
class RechargePresenterTest {

    @Mock
    lateinit var firebaseIntance: FirebaseMessaging

    @Mock
    lateinit var task: Task<String>

    @Mock
    lateinit var view: RechargeView

    @InjectMocks
    lateinit var presenter: RechargePresenter

    @Before
    fun setUp() {
        presenter = RechargePresenter(view)
    }


    @Test
    fun callIt() {
        `when`(firebaseIntance.token).thenReturn(task)

//        `when`(task.addOnCompleteListener(any())).then(object : Answer<Task<String>> {
//            override fun answer(invocation: InvocationOnMock?): Task<String> {
//                invocation?.getArgument<OnCompleteListener<String>>(0)?.onComplete(task)
//                return task
//            }
//        })

        `when`(task.addOnCompleteListener(any())).then { invocation ->
            invocation?.getArgument<OnCompleteListener<String>>(0)?.onComplete(task)
            task
        }

        presenter.isFirebase(firebaseIntance)
        verify(view).showRecharges(arrayOf(listOf()))
    }
}