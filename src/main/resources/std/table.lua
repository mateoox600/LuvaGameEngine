local Table = {}

function Table.has(t, v)
    local found = false
    local n = 0

    for _, x in ipairs(t) do
        if x == v then
            found = true
            n = n + 1
        end
    end

    return found, n
end

function Table.merge(t, t1)
    local r = {}
    for k, v in pairs(t) do
        r[k] = v
    end
    for k, v in pairs(t1) do
        r[k] = v
    end
    return r
end

return Table