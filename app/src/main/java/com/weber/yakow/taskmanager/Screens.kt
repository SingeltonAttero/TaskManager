package com.weber.yakow.taskmanager

import android.support.v4.app.Fragment
import com.weber.yakow.taskmanager.ui.auth.AuthFlowFragment
import com.weber.yakow.taskmanager.ui.auth.AuthFragment
import com.weber.yakow.taskmanager.ui.auth.PasswordRecoveryFragment
import com.weber.yakow.taskmanager.ui.manager.TaskManagerFlowFragment
import com.weber.yakow.taskmanager.ui.manager.TaskManagerFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object AuthFlow : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return AuthFlowFragment.newInstance()
        }
    }

    object AuthScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return AuthFragment.newInstance()
        }
    }

    object PasswordRecoverScreen : SupportAppScreen(){
        override fun getFragment(): Fragment {
            return PasswordRecoveryFragment.newInstance()
        }
    }


    object TaskManagerFlow : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return TaskManagerFlowFragment.newInstance()
        }
    }

    object TaskManagerScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return TaskManagerFragment.newInstance()
        }
    }


}