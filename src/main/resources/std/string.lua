local Table = require('<table.lua>')

local String = {}

function String.toString(o, i, p)
    i = i or 0
    p = p or {}
    local h, _ = Table.has(p, tostring(o));
    if h then
        return 'Reference loop, ' .. tostring(o)
    end
    if i >= 4 then
        return '...'
    end
    if type(o) == 'table' then
        local indent = string.rep('    ', i)
        local s = '{\n'
        for k,v in pairs(o) do
            if type(k) ~= 'number' then 
                k = '"' .. k .. '"' 
            end
            v = String.toString(v, i + 1, Table.merge({tostring(o)}, p))
            s = s .. indent .. '    [' .. k .. '] = ' .. v .. ',\n'
        end
        s = string.sub(s, 0, string.len(s) - 2)
        return s .. '\n' .. indent .. '}'
    else
        return tostring(o)
    end
end

return String