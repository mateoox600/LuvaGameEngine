
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