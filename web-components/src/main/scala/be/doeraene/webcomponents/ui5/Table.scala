package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.configkeys.{TableGrowingMode, TableMode}
import be.doeraene.webcomponents.ui5.eventtypes.HasDetail
import be.doeraene.webcomponents.ui5.internal.Slot
import com.raquo.domtypes.generic.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.{ReactiveHtmlAttr, ReactiveProp, ReactiveStyle}
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.compiletime.ops.int.<=

import scala.concurrent.duration.FiniteDuration
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.WebComponent

object Table extends WebComponent {

  @js.native
  trait RawElement extends js.Object {}

  @js.native
  @JSImport("@ui5/webcomponents/dist/Table.js", JSImport.Default)
  object RawImport extends WebComponent.WithMetadata

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref = dom.html.Element with RawElement

  protected val tag: HtmlTag[Ref] = customHtmlTag("ui5-table")

  lazy val busy: ReactiveHtmlAttr[Boolean]                = customHtmlAttr("busy", BooleanAsAttrPresenceCodec)
  lazy val busyDelay: ReactiveHtmlAttr[FiniteDuration]    = customHtmlAttr("busy-delay", FiniteDurationCodec)
  lazy val growing: ReactiveHtmlAttr[TableGrowingMode]    = customHtmlAttr("growing", TableGrowingMode.AsStringCodec)
  lazy val growingButtonSubtext: ReactiveHtmlAttr[String] = customHtmlAttr("growing-button-subtext", StringAsIsCodec)
  lazy val growingButtonText: ReactiveHtmlAttr[String]    = customHtmlAttr("growing-button-text", StringAsIsCodec)
  lazy val hideNoData: ReactiveHtmlAttr[Boolean]          = customHtmlAttr("hide-no-data", BooleanAsAttrPresenceCodec)
  lazy val mode: ReactiveHtmlAttr[TableMode]              = customHtmlAttr("mode", TableMode.AsStringCodec)
  lazy val noDataText: ReactiveHtmlAttr[String]           = customHtmlAttr("no-data-text", StringAsIsCodec)
  lazy val stickyColumnHeader: ReactiveHtmlAttr[Boolean] =
    customHtmlAttr("sticky-column-header", BooleanAsAttrPresenceCodec)

  object slots {
    val columns: Slot = new Slot("columns")
  }

  object events {
    val onLoadMore = new EventProp[dom.Event]("load-more")

    @js.native
    trait TableSelectionChangeDetail extends js.Object {
      def previouslySelectedRows: js.Array[TableRow.Ref] = js.native

      def selectedRows: js.Array[TableRow.Ref] = js.native
    }

    val onSelectionChange = new EventProp[dom.Event & HasDetail[TableSelectionChangeDetail]]("selection-change")
  }

  def column: TableColumn.type = TableColumn
  def row: TableRow.type       = TableRow

  def groupRow(mods: Mod[ReactiveHtmlElement[dom.HTMLElement]]*): HtmlElement =
    customHtmlTag[dom.HTMLElement]("ui5-table-group-row")(mods: _*)

}
