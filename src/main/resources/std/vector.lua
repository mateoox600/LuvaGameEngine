local Number = require('<number.lua>')

local Vector = {}

function Vector.from(x, y)
    return { ['x'] = x, ['y'] = y }
end

function Vector.inRange(v, min, max)
    if type(min) == 'number' then min = { ["x"] = min, ["y"] = min } end
    if type(max) == 'number' then max = { ["x"] = max, ["y"] = max } end
    return Number.inRange(v.x, min.x, max.x) and Number.inRange(v.y, min.y, max.y)
end

return Vector