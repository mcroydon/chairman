package com.postneo
package chairman

import blueeyes.{BlueEyesServer, BlueEyesServiceBuilder}
import blueeyes.concurrent.Future
import blueeyes.concurrent.Future._
import blueeyes.core.data.{ByteChunk, BijectionsChunkJson}
import blueeyes.core.http.combinators.HttpRequestCombinators
import blueeyes.core.http.MimeTypes._
import blueeyes.core.http.{HttpStatus, HttpRequest, HttpResponse}
import blueeyes.core.service.ServerHealthMonitorService
import blueeyes.json.JsonAST._
import java.util.Date
import java.text.SimpleDateFormat
import net.lag.configgy.ConfigMap

object ChairmanServer extends BlueEyesServer with ChairmanService with ServerHealthMonitorService {
    override def main(args: Array[String]) = super.main(Array("--configFile", "chairman.conf"))
}

trait ChairmanService extends BlueEyesServiceBuilder with HttpRequestCombinators with BijectionsChunkJson {
    val chairmanService = service("chairman", "1.0.0") {
        healthMonitor { monitor => context => 
            startup {
                ChairmanConfig(context.config.configMap("foo")).future
            } ->
            request { chairmanConfig: ChairmanConfig =>
                import chairmanConfig._
                
                path("/test/") {
                    produce(application/json) {
                        get { request: HttpRequest[ByteChunk] =>
                            Future.sync(HttpResponse[JValue](
                                content = Some(JArray(List("Hello", "BlueEyes!")))
                            ))
                        }
                    }
                } ~
                path("/time/") {
                    produce(application/json) {
                        get { request: HttpRequest[ByteChunk] =>
                            val now = new Date
                            val format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z")
                            Future.sync(HttpResponse[JValue](
                                content = Some(JArray(List(format.format(now))))
                            ))
                        }
                    }
                }
            } ->
            shutdown {chairmanConfig: ChairmanConfig =>
                ().future
            }
        }
    }
}

case class ChairmanConfig(config: ConfigMap) {}
