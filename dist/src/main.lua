local String = require('<string.lua>')
local Vector = require('<vector.lua>')

local cat = load('./cat.png');

local clicks = 0

on('draw', function (drawer)
    drawer:drawRect(25, 25, 50, 50, Colors.fromRGB(255, 0, 0))
    drawer:drawText('Clicks: ' .. clicks, 100, 25, 16, Colors.BLACK)
    drawer:drawTexture(cat, 100, 100, Colors.WHITE)
end)

on('mouseButtonPressed', function(button, x, y)
    if button ~= MouseButton.MOUSE_BUTTON_LEFT then return end
    if not Vector.inRange(Vector.from(x, y), 25, 75) then return end
    clicks = clicks + 1
    print(String.toString(Input:getMouseWheelDelta()))
    print(String.toString(Input:getMousePosition()))
end)

on('keyPressed', function(key)
    if key ~= KeyboardButton.KEY_SPACE then return end
    clicks = clicks + 1
end)