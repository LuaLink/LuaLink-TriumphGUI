package xyz.galaxyy.lualink.addons.triumphgui.functions;

import dev.triumphteam.gui.components.GuiAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

public class LuaGuiAction implements GuiAction<InventoryClickEvent> {
  private final LuaValue luaFunction;

  public LuaGuiAction(LuaValue luaFunction) {
    this.luaFunction = luaFunction;
  }

  @Override
  public void execute(InventoryClickEvent event) {
    luaFunction.invoke(CoerceJavaToLua.coerce(event));
  }
}
