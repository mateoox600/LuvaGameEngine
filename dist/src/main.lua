local String = require('<string.lua>')
local Vector = require('<vector.lua>')

local cat = load('./cat.png');

local clicks = 0
local rects = {}
local selecting = false
local startPos = { ['x'] = 0, ['y'] = 0 }

on('draw', function(drawer)
    drawer:fillRect(25, 25, 50, 50, Colors.fromRGB(255, 0, 0))
    drawer:drawText('Clicks: ' .. clicks, 100, 25, 16, Colors.BLACK)
    drawer:drawTexture(cat, 100, 100, Colors.WHITE)
    if selecting then
        local currentPos = camera:getScreenToWorld2D(Input:getMousePosition().x, Input:getMousePosition().y)
        local x = math.min(startPos.x, currentPos.x)
        local y = math.min(startPos.y, currentPos.y)
        local width = math.max(startPos.x, currentPos.x) - x
        local height = math.max(startPos.y, currentPos.y) - y
        drawer:strokeRect(x, y, width, height, Colors.BLACK)
    end
    for _, rect in pairs(rects) do
        drawer:strokeRect(rect.x, rect.y, rect.w, rect.h, Colors.BLACK)
    end
end)

on('mouseButtonPressed', function(button)
    if button == MouseButton.MOUSE_BUTTON_LEFT and not selecting then
        selecting = true
        startPos = camera:getScreenToWorld2D(Input:getMousePosition().x, Input:getMousePosition().y)
    end
end)

on('mouseButtonReleased', function(button)
    if button == MouseButton.MOUSE_BUTTON_LEFT and selecting then
        selecting = false
        local currentPos = camera:getScreenToWorld2D(Input:getMousePosition().x, Input:getMousePosition().y)
        local x = math.min(startPos.x, currentPos.x)
        local y = math.min(startPos.y, currentPos.y)
        local width = math.max(startPos.x, currentPos.x) - x
        local height = math.max(startPos.y, currentPos.y) - y
        table.insert(rects, { ['x'] = x, ['y'] = y, ['w'] = width, ['h'] = height })
    end
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
