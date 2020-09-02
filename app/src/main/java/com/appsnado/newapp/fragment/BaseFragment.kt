package com.appsnado.newapp.fragment

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.appsnado.newapp.BaseApplication.getPublishSubject
import com.appsnado.newapp.activities.BaseActivity
import com.appsnado.newapp.constants.AppConstants
import com.appsnado.newapp.widget.TitleBar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.function.Consumer


abstract class BaseFragment : Fragment(), View.OnClickListener {

    protected val view: View? = null
    var sharedPreferenceManager: SharedPreferenceManager? = null
    var TAG = "Logging Tag"
    var onCreated = false
    var subscription: Disposable? = null


    /**
     * This is an abstract class, we should inherit our fragment from this class
     */
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceManager = SharedPreferenceManager.getInstance(context)
        onCreated = false
    }

/*    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        view = inflater.inflate(getFragmentLayout(), container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBaseActivity()!!.titleBar.resetViews()
        getBaseActivity()!!.drawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED) // Default Locked in this project
        getBaseActivity()!!.drawerLayout!!.closeDrawer(GravityCompat.START)
        //subscribeToNewPacket(this)
    }


    fun getCurrentUser(): UserModel? {
        return sharedPreferenceManager.getCurrentUser()
    }

    fun getToken(): String? {
        return sharedPreferenceManager.getString(AppConstants.KEY_TOKEN)
    }

    fun getOneTimeToken(): String? {
        return sharedPreferenceManager.getString(AppConstants.KEY_ONE_TIME_TOKEN)
    }

    fun putOneTimeToken(token: String?) {
        sharedPreferenceManager.putValue(AppConstants.KEY_ONE_TIME_TOKEN, token)
    }

    abstract fun getDrawerLockMode(): Int


    // Use  UIHelper.showSpinnerDialog
    @Deprecated("")
    fun setSpinner(
        adaptSpinner: ArrayAdapter<*>?,
        textView: TextView?,
        spinner: Spinner?
    ) {
        if (adaptSpinner == null || spinner == null) return
        //selected item will look like a spinner set from XML
//        simple_list_item_single_choice
        adaptSpinner.setDropDownViewResource(R.layout.simple_list_item_single_choice)
        spinner.adapter = adaptSpinner
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                val str = spinner.getItemAtPosition(position).toString()
                if (textView != null) textView.text = str
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }


    protected abstract fun getFragmentLayout(): Int

    fun getBaseActivity(): BaseActivity? {
        return activity as BaseActivity?
    }


    abstract fun setTitlebar(titleBar: TitleBar?)


    abstract fun setListeners()

    override fun onResume() {
        super.onResume()
        onCreated = true
        setListeners()
        if (getBaseActivity() != null) {
            setTitlebar(getBaseActivity()!!.titleBar)
        }
        if (getBaseActivity() != null && getBaseActivity()!!.window.decorView != null) {
            KeyboardHelper.hideSoftKeyboard(
                getBaseActivity(),
                getBaseActivity()!!.window.decorView
            )
        }
    }

    override fun onPause() {
        if (getBaseActivity() != null && getBaseActivity()!!.window.decorView != null) {
            KeyboardHelper.hideSoftKeyboard(
                getBaseActivity(),
                getBaseActivity()!!.window.decorView
            )
        }
        super.onPause()
    }


    /*fun notifyToAll(event: Int, data: Any?) {
        getPublishSubject()!!.onNext(Pair(event, data))
    }*/

   /* protected fun subscribeToNewPacket(newPacketReceivedListener: OnNewPacketReceivedListener) {
        subscription = getPublishSubject()
            ?.observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Consumer<Pair>() {
                @Throws(Exception::class)
                fun accept(@NonNull pair: Pair) {
                    Log.e("abc", "on accept")
                    newPacketReceivedListener.onNewPacket(pair.first as Int, pair.second)
                }
            })
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("abc", "onDestroyView")
        if (subscription != null) subscription!!.dispose()
    }


    fun showNextBuildToast() {
        UIHelper.showToast(context, "This feature is in progress")
    }


/*    fun saveAndOpenFile(webResponse: WebResponse<String?>) {
        val fileName: String =
            AppConstants.FILE_NAME + DateManager.getTime(DateManager.getCurrentMillis())
                .toString() + ".pdf"
        val path: String = FileManager.writeResponseBodyToDisk(
            context,
            webResponse.result,
            fileName,
            AppConstants.getUserFolderPath(context),
            true,
            true
        )

//                                final File file = new File(AppConstants.getUserFolderPath(getContext())
//                                        + "/" + fileName + ".pdf");
        val file = File(path)
        Handler().postDelayed(Runnable { FileManager.openFile(context, file) }, 100)
    }*/

    fun onNewPacket(event: Int, data: Any?) {
        when (event) {
        }
    }

    fun logoutClick(baseFragment: BaseFragment) {
       /* val context: Context? = baseFragment.context
        val genericDialogFragment: GenericDialogFragment = GenericDialogFragment.newInstance()
        genericDialogFragment.setTitle("Logout")
        genericDialogFragment.setMessage(context.getString(R.string.areYouSureToLogout))
        genericDialogFragment.setButton1("Yes", object : GenericClickableInterface() {
            fun click() {
                genericDialogFragment.dismiss()
                baseFragment.sharedPreferenceManager.clearDB()
                baseFragment.getBaseActivity()
                    ?.clearAllActivitiesExceptThis(MainActivity::class.java)
            }
        })
        genericDialogFragment.setButton2("No", object : GenericClickableInterface() {
            fun click() {
                genericDialogFragment.getDialog().dismiss()
            }
        })
        genericDialogFragment.show(baseFragment.getBaseActivity()!!.supportFragmentManager, null)*/
    }

    override fun onClick(p0: View?) {

    }


}