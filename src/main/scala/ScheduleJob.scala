import java.text.SimpleDateFormat
import java.util.{Date, TimeZone}

import scala.concurrent.duration._

import ScheduleActor.IncrementNumber
import akka.actor.{ActorSystem, Props}

/**
 * Created by deepak on 22/1/17.
 */
object ScheduleJob extends App {

  val system = ActorSystem("SchedulerSystem")
  val schedulerActor = system.actorOf(Props(classOf[ScheduleActor]), "Actor")
  implicit val ec = system.dispatcher
  system.scheduler
    .schedule(calculateInitialDelay().milliseconds, 60.seconds)(
      schedulerActor ! IncrementNumber)

  def calculateInitialDelay(): Long = {
    val now = new Date()
    val sdf = new SimpleDateFormat("HH:mm:ss")
    sdf.setTimeZone(TimeZone.getTimeZone("IST"))
    val time1 = sdf.format(now)
    val time2 = "00:00:00"
    val format = new SimpleDateFormat("HH:mm:ss")
    val date1 = format.parse(time1)
    val date2 = format.parse(time2)
    val timeDifference = date2.getTime() - date1.getTime()
    println(timeDifference + "timedifference" + "}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}")
    val calculatedTime = if (timeDifference < 0) (Constant.DAYHOURS + timeDifference) else timeDifference
    // val modifiedDate = projectDbService.getModifiedDate("sumit")
    //println("||||||||||||||||||||||||" + modifiedDate.toString() + "*******************************")

    println("calculated time ======================" + calculatedTime)
    calculatedTime
  }

}
