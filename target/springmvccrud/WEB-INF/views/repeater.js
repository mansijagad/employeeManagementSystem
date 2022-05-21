jQuery.fn.extend({
    createRepeater: function () {
        var generateId = function (string) {
            return string
                .replace(/\[/g, '_')
                .replace(/\]/g, '')
                .toLowerCase();
        };

        var addItem = function (items, key, fresh = true) {
            var newEle=items.clone();
            var itemContent = newEle;
            var group = itemContent.data("group");
            var item = itemContent;
            var input = item.find('input,select,textarea');

            input.each(function (index, el) {
                var attrName = $(el).data('name');
                var skipName = $(el).data('skip-name');
                if (skipName != true) {
                    $(el).attr("name", group + "[" + key + "]" + "[" + attrName + "]");
                } else {
                    if (attrName != 'undefined') {
                        $(el).attr("name", attrName);
                    }
                }
                $(el).attr('value', '');
                

                $(el).attr('id', generateId($(el).attr('name')));
                $(el).parent().find('label').attr('for', generateId($(el).attr('name')));
            })

            var itemClone = newEle;
            var removeButton = itemClone.find('.remove-btn');
            removeButton.attr("value","Remove")
           removeButton.on("click", function() {
                $(this).parents('.items').remove();
                key--;
            }); 
            
            var newItem = $("<div class='items'>" + itemClone.html() + "<div/>");
            newItem.attr('data-index', key)

            repeater.append(newItem);
        };
        /* find elements */
        var repeater = this;
        var items = $("body").find(".items");
        var key = 0;
        console.log(key);
        var addButton = repeater.find('.repeater-add-btn');

        var removeButton = repeater.find('.remove-btn');
        
        removeButton.on("click", function() {
            $(this).parents('.items').remove();
            key--;
        });
            


        /* handle click and add items */
        addButton.on("click", function () {
		if($(items[0])){			
           addItem($(items[0]), key);
		}
            key++;
        }.bind(this));
    }
});