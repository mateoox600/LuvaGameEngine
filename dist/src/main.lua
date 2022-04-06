local String = require('<string.lua>')
local Vector = require('<vector.lua>')

local cat = load('./cat.png');

local clicks = 0

on('draw', function(drawer)
    drawer:drawRect(25, 25, 50, 50, Colors.fromRGB(255, 0, 0))
    drawer:drawText('Clicks: ' .. clicks, 100, 25, 16, Colors.BLACK)
    drawer:drawTexture(cat, 100, 100, Colors.WHITE)
end)

on('mouseButtonPressed', function(button, x, y)
    if button ~= MouseButton.MOUSE_BUTTON_LEFT then return end
    if not Vector.inRange(Vector.from(x, y), camera:getWorldToScreen2D(25, 25), camera:getWorldToScreen2D(75, 75)) then return end
    clicks = clicks + 1
    print(String.toString(Input:getMouseWheelDelta()))
    print(String.toString(Input:getMousePosition()))
end)

on('keyPressed', function(key)
    if key == KeyboardButton.KEY_SPACE then
        clicks = clicks + 1
    end
end)

on('keyDown', function(key)
    if key == KeyboardButton.KEY_Z then
        local v = camera:getTarget();
        camera:setTarget(v.x, v.y - 1)
    elseif key == KeyboardButton.KEY_S then
        local v = camera:getTarget();
        camera:setTarget(v.x, v.y + 1)
    elseif key == KeyboardButton.KEY_Q then
        local v = camera:getTarget();
        camera:setTarget(v.x - 1, v.y)
    elseif key == KeyboardButton.KEY_D then
        local v = camera:getTarget();
        camera:setTarget(v.x + 1, v.y)
    end
end)
