# LuaLink-TriumphGUI
A LuaLink Addon which provides a simple Lua API for creating GUIs with [TriumphGUI](https://github.com/TriumphTeam/triumph-gui/). 

# Credits
- [TriumphGUI](https://github.com/TriumphTeam/triumph-gui/) for the wonderful GUI library

## Example usage
```lua
local TriumphGUI = addons.get("TriumphGUI")
local MiniMessage = import "net.kyori.adventure.text.minimessage.MiniMessage":miniMessage()
local Material = import "org.bukkit.Material"
local function ConstructNormalGUI()
    local gui = TriumphGUI.newGUI()
        :title(MiniMessage:deserialize("<gradient:#ff5733:#00cc99>Test GUI</gradient>"))
        :create()
    gui:disableItemPlace()
    gui:disableItemTake()

    local item1 = TriumphGUI.buildItem():from(Material.STONE):asGuiItem()
    local item2 = TriumphGUI.buildItem():from(Material.STONE):asGuiItem(TriumphGUI.action(function(event)
        local ply = event:getWhoClicked()
        ply:sendRichMessage("<rainbow>You just clicked item2 in a Lua GUI", {})
    end))

    gui:addItem(false, {item1, item2})

    return gui
end


local function ConstructPaginatedGUI()
    local gui = TriumphGUI.newPaginatedGUI()
        :title(MiniMessage:deserialize("<gradient:#ff5733:#00cc99>Test Paginated GUI</gradient>"))
        :rows(6)
        :create()
        gui:disableItemPlace()
        gui:disableItemTake()
    local previousItem = TriumphGUI.buildItem():from(Material.PAPER):name(MiniMessage:deserialize("Previous")):asGuiItem(TriumphGUI.action(function(event)
        gui:previous()
    end))
    local nextItem = TriumphGUI.buildItem():from(Material.PAPER):name(MiniMessage:deserialize("Next")):asGuiItem(TriumphGUI.action(function(event)
        gui:next()
    end))

    gui:setItem(6,3, previousItem)
    gui:setItem(6, 7, nextItem)
    local allItems = Material:values()
    for i=2, allItems.length do
        if i == 200 then break end -- Let's not freeze the server
        gui:addItem(TriumphGUI.buildItem():from(Material:valueOf(tostring(allItems[i]))):asGuiItem())
    end
    return gui
end

script.registerSimpleCommand(function(sender, args)
    local gui = ConstructNormalGUI()

    gui:open(sender)
end, {
    name = "tgui",
})

script.registerSimpleCommand(function(sender, args)
    local gui = ConstructPaginatedGUI()
    gui:open(sender)
end, {
    name = "pgui",
})
```
