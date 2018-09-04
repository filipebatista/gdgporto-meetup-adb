package com.filipebaptista.gdgportomeetup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.format.DateUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileDescriptor
import java.io.PrintWriter

class MainActivity : AppCompatActivity() {
    companion object {
        const val BANNER = """
   _____ _____   _____   _____           _
  / ____|  __ \ / ____| |  __ \         | |
 | |  __| |  | | |  __  | |__) |__  _ __| |_ ___
 | | |_ | |  | | | |_ | |  ___/ _ \| '__| __/ _ \
 | |__| | |__| | |__| | | |  | (_) | |  | || (_) |
  \_____|_____/ \_____| |_|   \___/|_|   \__\___/

                                                  """
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomvalue.text = (1..100).shuffled().last().toString()
    }

    override fun dump(prefix: String?, fd: FileDescriptor?, writer: PrintWriter?, args: Array<out String>?) {
        super.dump(prefix, fd, writer, args)
        writer?.println("======================================")
        writer?.println(BANNER)
        writer?.println("Hello GDG Porto MeetUp")
        writer?.print("The random value in Screen is:")
        writer?.println(randomvalue.text)
        writer?.print("Current Time is: ")
        writer?.println(DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME))
        writer?.print("======================================")
    }
}
