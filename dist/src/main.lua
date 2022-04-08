local String = require('<string.lua>')
local Vector = require('<vector.lua>')

use('./src/mouvementsManager.lua')

local cat = load('./cat.png');

pipe('starting', function(str)
    return str .. ' main file !?!'
end, function(str)
    return str:gsub('%!%?%!', '%!%!')
end, function(str)
    print(str)
end)

local clicks = 0
local rects = {}
local selecting = false
local startPos = { ['x'] = 0, ['y'] = 0 }
local function getSelectionRect()
    local currentPos = camera:getScreenToWorld2D(Input:getMousePosition().x, Input:getMousePosition().y)
    local x = math.min(startPos.x, currentPos.x)
    local y = math.min(startPos.y, currentPos.y)
    local width = math.max(startPos.x, currentPos.x) - x
    local height = math.max(startPos.y, currentPos.y) - y
    return { ['x'] = x, ['y'] = y, ['width'] = width, ['height'] = height }
end

print(String.toString(startPos))

on('draw', function(drawer)
    drawer:fillRect(25, 25, 50, 50, Colors.fromRGB(255, 0, 0))
    drawer:drawText('Clicks: ' .. clicks, 100, 25, 16, Colors.BLACK)
    drawer:drawTexture(cat, 100, 100, Colors.WHITE)
    if selecting then
        local rect = getSelectionRect()
        drawer:strokeRect(rect.x, rect.y, rect.width, rect.height, Colors.BLACK)
    end
    for _, rect in pairs(rects) do
        drawer:strokeRect(rect.x, rect.y, rect.width, rect.height, Colors.BLACK)
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
        table.insert(rects, getSelectionRect())
    end
end)

on('keyPressed', function(key)
    if key == KeyboardButton.KEY_SPACE then
        clicks = clicks + 1
    end
end)
