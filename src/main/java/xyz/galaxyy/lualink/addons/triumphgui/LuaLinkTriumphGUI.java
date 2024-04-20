package xyz.galaxyy.lualink.addons.triumphgui;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.galaxyy.lualink.addons.triumphgui.functions.LuaFunctions;
import xyz.galaxyy.lualink.api.LuaLinkAPI;
import xyz.galaxyy.lualink.api.addons.LuaAddon;

public final class LuaLinkTriumphGUI extends JavaPlugin {
  @Override
  public void onEnable() {
    LuaAddon luaAddon = new LuaAddon();

    luaAddon.addFunction("newGUI", LuaFunctions.NEW_GUI);

    luaAddon.addFunction("newPaginatedGUI", LuaFunctions.NEW_PAGINATED_GUI);
    luaAddon.addFunction("newScrollingGUI", LuaFunctions.NEW_SCROLLING_GUI);
    luaAddon.addFunction("newStorageGUI", LuaFunctions.NEW_STORAGE_GUI);
    luaAddon.addFunction("buildItem", LuaFunctions.BUILD_ITEM);
    luaAddon.addFunction("action", LuaFunctions.GUI_ACTION);
    LuaLinkAPI.Companion.registerAddon("TriumphGUI", luaAddon);
  }
}
