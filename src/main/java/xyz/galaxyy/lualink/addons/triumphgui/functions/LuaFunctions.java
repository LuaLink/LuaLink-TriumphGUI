package xyz.galaxyy.lualink.addons.triumphgui.functions;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

public final class LuaFunctions {
  public static final LuaFunction NEW_GUI =
      new ZeroArgFunction() {
        @Override
        public LuaValue call() {
          return CoerceJavaToLua.coerce(Gui.gui());
        }
      };

  public static final LuaFunction NEW_PAGINATED_GUI =
      new ZeroArgFunction() {
        @Override
        public LuaValue call() {
          return CoerceJavaToLua.coerce(Gui.paginated());
        }
      };

  public static final LuaFunction NEW_SCROLLING_GUI =
      new ZeroArgFunction() {
        @Override
        public LuaValue call() {
          return CoerceJavaToLua.coerce(Gui.scrolling());
        }
      };

  public static final LuaFunction NEW_STORAGE_GUI =
      new ZeroArgFunction() {
        @Override
        public LuaValue call() {
          return CoerceJavaToLua.coerce(Gui.storage());
        }
      };

  public static final LuaFunction BUILD_ITEM =
      new ZeroArgFunction() {
        @Override
        public LuaValue call() {
          return CoerceJavaToLua.coerce(ItemBuilder.class);
        }
      };

  public static final LuaFunction GUI_ACTION =
      new OneArgFunction() {
        @Override
        public LuaValue call(LuaValue cb) {
          if (!cb.isfunction()) {
            throw new IllegalArgumentException("Expected function, got " + cb.typename());
          } else {
            return CoerceJavaToLua.coerce(new LuaGuiAction(cb.checkfunction()));
          }
        }
      };
}
