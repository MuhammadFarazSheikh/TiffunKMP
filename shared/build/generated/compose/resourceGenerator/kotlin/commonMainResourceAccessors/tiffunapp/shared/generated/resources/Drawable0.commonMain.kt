@file:OptIn(InternalResourceApi::class)

package tiffunapp.shared.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceContentHash
import org.jetbrains.compose.resources.ResourceItem

private const val MD: String = "composeResources/tiffunapp.shared.generated.resources/"

@delegate:ResourceContentHash(-1_763_380_967)
internal val Res.drawable.arrow_down: DrawableResource by lazy {
      DrawableResource("drawable:arrow_down", setOf(
        ResourceItem(setOf(), "${MD}drawable/arrow_down.png", -1, -1),
      ))
    }

@delegate:ResourceContentHash(379_089_144)
internal val Res.drawable.compose_multiplatform: DrawableResource by lazy {
      DrawableResource("drawable:compose_multiplatform", setOf(
        ResourceItem(setOf(), "${MD}drawable/compose-multiplatform.xml", -1, -1),
      ))
    }

@delegate:ResourceContentHash(-420_538_736)
internal val Res.drawable.tiffun: DrawableResource by lazy {
      DrawableResource("drawable:tiffun", setOf(
        ResourceItem(setOf(), "${MD}drawable/tiffun.png", -1, -1),
      ))
    }

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("arrow_down", Res.drawable.arrow_down)
  map.put("compose_multiplatform", Res.drawable.compose_multiplatform)
  map.put("tiffun", Res.drawable.tiffun)
}
