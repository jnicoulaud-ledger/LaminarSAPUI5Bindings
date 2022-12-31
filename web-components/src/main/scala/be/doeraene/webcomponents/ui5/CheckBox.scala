package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.configkeys.{ButtonDesign, IconName, ValueState, WrappingType}
import be.doeraene.webcomponents.ui5.eventtypes.EventWithPreciseTarget
import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.WebComponent

/** Allows the user to set a binary value, such as true/false or yes/no for an item.
  *
  * @see
  *   <a href="https://sap.github.io/ui5-webcomponents/playground/components/CheckBox/">the doc</a> for more
  *   information.
  */
object CheckBox extends WebComponent with HasIcon with HasAccessibleName with HasName with HasText {

  @js.native
  trait RawElement extends js.Object {
    def checked: Boolean = js.native
  }

  @js.native
  @JSImport("@ui5/webcomponents/dist/CheckBox.js", JSImport.Default)
  object RawImport extends WebComponent.WithMetadata

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref = dom.html.Element with RawElement

  protected val tag: HtmlTag[Ref] = customHtmlTag("ui5-checkbox")

  lazy val checked: ReactiveHtmlAttr[Boolean]       = customHtmlAttr("checked", BooleanAsAttrPresenceCodec)
  lazy val disabled: ReactiveHtmlAttr[Boolean]      = customHtmlAttr("disabled", BooleanAsAttrPresenceCodec)
  lazy val indeterminate: ReactiveHtmlAttr[Boolean] = customHtmlAttr("indeterminate", BooleanAsAttrPresenceCodec)
  lazy val readonly: ReactiveHtmlAttr[Boolean]      = customHtmlAttr("readonly", BooleanAsAttrPresenceCodec)
  lazy val required: ReactiveHtmlAttr[Boolean]      = customHtmlAttr("required", BooleanAsAttrPresenceCodec)

  lazy val valueState: ReactiveHtmlAttr[ValueState] = customHtmlAttr("value-state", ValueState.AsStringCodec)

  lazy val wrappingType: ReactiveHtmlAttr[WrappingType] = customHtmlAttr("wrapping-type", WrappingType.AsStringCodec)

  object slots {}

  object events {
    val onChange: EventProp[EventWithPreciseTarget[Ref]] = new EventProp("change")
  }

  

}
