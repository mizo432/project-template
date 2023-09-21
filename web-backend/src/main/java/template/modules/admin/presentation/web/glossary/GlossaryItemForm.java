package template.modules.admin.presentation.web.glossary;

import com.undecided.primitive.list.Lists2;
import lombok.Data;
import template.modules.admin.domain.model.glossary.GlossaryItem;
import template.modules.admin.domain.model.glossary.attribute.GlossaryItemAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * 祝日フォーム
 */
@Data
public class GlossaryItemForm {
    private Long glossaryItemId;
    private String word;
    private String kanaWord;
    private String description;

    /**
     * ファクトリーメソッド
     *
     * @param glossaryItem 祝日
     * @return 祝日フォーム
     */
    public static GlossaryItemForm reconstruct(final GlossaryItem glossaryItem) {
        GlossaryItemForm form = new GlossaryItemForm();
        form.setGlossaryItemId(glossaryItem.getGlossaryItemId().getValue());
        form.setWord(glossaryItem.getAttribute().getWord().getValue());
        form.setKanaWord(glossaryItem.getAttribute().getKanaWord().getValue());
        form.setDescription(glossaryItem.getAttribute().getDescription().getValue());
        return form;

    }

    /**
     * 新規登録用モデルに変換する
     *
     * @return 祝日
     */
    public GlossaryItem convertToInsertModel() {
        return GlossaryItem.create(GlossaryItemAttribute.create(getWord(), getKanaWord(), getDescription()));

    }

    /**
     * 更新用モデルに変換する
     *
     * @return 祝日
     */
    public GlossaryItem convertToUpdateModel() {
        return GlossaryItem.create(glossaryItemId, GlossaryItemAttribute.create(getWord(), getKanaWord(), getDescription()));

    }


    /**
     * 祝日フォームのファーストクラスコレクション
     */
    public static class GlossaryItemFormList {
        public static List<GlossaryItemForm> reconstruct(final GlossaryItem.Glossary glossary) {
            ArrayList<GlossaryItemForm> glossaryItemFormList = Lists2.newArrayList();
            for (GlossaryItem glossaryItem : glossary.getValue()) {
                glossaryItemFormList.add(GlossaryItemForm.reconstruct(glossaryItem));

            }

            return glossaryItemFormList;

        }
    }
}
