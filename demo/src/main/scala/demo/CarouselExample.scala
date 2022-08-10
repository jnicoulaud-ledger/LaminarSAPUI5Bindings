package demo

import be.doeraene.webcomponents.ui5.*
import be.doeraene.webcomponents.ui5.configkeys.*
import com.raquo.laminar.api.L.*
import demo.helpers.{DemoPanel, Example, MTG}

object CarouselExample extends Example("Carousel") {

  private def threeMagicWallpapers: List[Carousel.ModFunction] = List(
    _ =>
      img(
        src := "https://media.magic.wizards.com/images/wallpaper/senseis-divining-top-2x2-background-1280x960.jpg"
      ),
    _ => img(src := "https://media.magic.wizards.com/images/wallpaper/mana-vault-2x2-background-1280x960.jpg"),
    _ =>
      img(
        src := "https://media.magic.wizards.com/images/wallpaper/sparas_headquarters_kieran_yanner_1280x960_poozxbqpcw.jpg"
      )
  )

  def component: HtmlElement = div(
    styleTag("""
    |ui5-carousel > img {
    |  max-width: 500px
    |}
    |""".stripMargin),
    DemoPanel("Carousel With Single Item per Page")(
      //-- Begin: Carousel With Single Item per Page
      Carousel(threeMagicWallpapers: _*)
      //-- End
    ),
    DemoPanel("Carousel with Multiple items per Page")(
      //-- Begin: Carousel with Multiple items per Page
      Carousel(
        _.itemsPerPageS := 1,
        _.itemsPerPageM := 2,
        _.itemsPerPageL := 2,
        _ => MTG.manaSymbolsShortNames.map(name => img(src := MTG.manaSymbolsRefs(name), alt := name))
      )
      //-- End
    ),
    DemoPanel("Carousel With Arrow Placement and Cyclic")(
      //-- Begin: Carousel With Arrow Placement and Cyclic
      Carousel(
        threeMagicWallpapers ++ List(_.arrowsPlacement := CarouselArrowsPlacement.Navigation, _.cyclic := true): _*
      )
      //-- End
    )
  )

}
