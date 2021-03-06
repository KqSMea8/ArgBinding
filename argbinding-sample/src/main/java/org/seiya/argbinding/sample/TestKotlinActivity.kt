package org.seiya.argbinding.sample

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import org.seiya.argbinding.ArgBinding
import org.seiya.argbinding.annotation.BindArg
import org.seiya.argbinding.annotation.BindTarget
import org.seiya.argbinding.sample.base.BaseActivity
import org.seiya.argbinding.sample.model.ParcelableUser
import org.seiya.argbinding.sample.model.SerializableUser
import java.util.*

/**
 * @author Andy
 * @date 2019/2/17
 */
@BindTarget
class TestKotlinActivity : BaseActivity() {

    /**
     * 年龄.
     */
    @BindArg
    @JvmField
    var age: Int = 0
    @BindArg(value = "ageOther", required = false)
    @JvmField
    var age2: Int = 0
    @BindArg
    lateinit var name: String
    @BindArg(required = false)
    lateinit var p: ParcelableUser
    @BindArg
    lateinit var mS1: SerializableUser
    @BindArg(required = false)
    lateinit var ageArray: IntArray
    @BindArg(required = false)
    lateinit var age2Array: Array<Int>
    @BindArg(required = false)
    lateinit var nameArray: Array<String>
    @BindArg(required = false)
    lateinit var pArray: Array<ParcelableUser>
    @BindArg(required = false)
    lateinit var sArray: Array<SerializableUser>
    @BindArg(required = false)
    lateinit var nameList: ArrayList<String>
    @BindArg(required = false)
    lateinit var pList: ArrayList<ParcelableUser>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_activity)
        ArgBinding.get().bind(this)
        Log.d(TAG, "onCreate")
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show()

        val sBuilder = StringBuilder()
        sBuilder.append("name:$name\n")
        sBuilder.append("age:$age\n")
        sBuilder.append("age2:$age2\n")
        sBuilder.append("p:$p\n")
        sBuilder.append("mS1:$mS1\n")

        sBuilder.append("ageArray:" + Arrays.toString(ageArray) + "\n")
        sBuilder.append("nameArray:" + Arrays.toString(nameArray) + "\n")
        sBuilder.append("pArray:" + Arrays.toString(pArray) + "\n")
        sBuilder.append("sArray:" + Arrays.toString(sArray) + "\n")
        sBuilder.append("nameList:$nameList\n")
        sBuilder.append("pList:$pList\n")
        sBuilder.append("ageBase:$ageBase\n")

        val textView: TextView = findViewById(R.id.tv)
        textView.text = sBuilder.toString()
    }

    companion object {
        private const val TAG = "TestKotlinActivity"
    }
}
