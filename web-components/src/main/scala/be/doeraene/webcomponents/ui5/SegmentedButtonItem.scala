package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.configkeys.{ButtonDesign, ColourScheme, IconName}
import be.doeraene.webcomponents.ui5.eventtypes.EventWithPreciseTarget
import be.doeraene.webcomponents.ui5.internal.Slot
import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.WebComponent

/** Users can use the ui5-segmented-button-item as part of a ui5-segmented-button.
  *
  * @see
  *   <a href="https://sap.github.io/ui5-webcomponents/playground/components/SegmentedButton/">the doc</a> for more
  *   information.
  */
object SegmentedButtonItem extends WebComponent with HasAccessibleName with HasIcon {

  @js.native
  trait RawElement extends js.Object {}

  @js.native
  @JSImport("@ui5/webcomponents/dist/SegmentedButtonItem.js", JSImport.Default)
  object RawImport extends WebComponent.WithMetadata

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref = dom.html.Element with RawElement

  protected val tag: HtmlTag[Ref] = customHtmlTag("ui5-segmented-button-item")

  lazy val design: ReactiveHtmlAttr[ButtonDesign] = customHtmlAttr("design", ButtonDesign.AsStringCodec)

  lazy val iconEnd: ReactiveHtmlAttr[Boolean] = customHtmlAttr("icon-end", BooleanAsAttrPresenceCodec)

  lazy val submits: ReactiveHtmlAttr[Boolean] = customHtmlAttr("submits", BooleanAsAttrPresenceCodec)

  lazy val pressed: ReactiveHtmlAttr[Boolean] = customHtmlAttr("pressed", BooleanAsAttrPresenceCodec)

  lazy val accessibilityAttributes: ReactiveHtmlAttr[js.Object] = ??? // todo

  lazy val disabled: ReactiveHtmlAttr[Boolean] = customHtmlAttr("disabled", BooleanAsAttrPresenceCodec)

  lazy val tooltip: ReactiveHtmlAttr[String] = customHtmlAttr("tooltip", StringAsIsCodec)

  object slots {}

  object events {
    val onClick: EventProp[EventWithPreciseTarget[Ref]] = new EventProp("click")
  }

  

}
