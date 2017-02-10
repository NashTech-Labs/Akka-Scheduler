
import akka.actor.Actor

class ScheduleActor extends Actor {

  import ScheduleActor._

  var count = 1

  def receive: PartialFunction[Any, Unit] = {
    case IncrementNumber => count+=1
    println(count)
  }

}

/**
 * Created by deepak on 22/1/17.
 */
object ScheduleActor {

  case object IncrementNumber

}

